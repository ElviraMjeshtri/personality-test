<template>
  <div class="flex max-w-5xl justify-center items-center h-screen">
    <div class="shadow-pink-300 p-12 rounded-lg shadow-lg w-full mt-8 bg-white">
      <h1 class="pb-12  font-bold text-5xl text-center text-pink-600">Personality test</h1>
      <p class="text-2xl">{{ question.question }} </p>
      <label :for="index"
             class="block mt-4 border border-pink-300 rounded-lg py-2 px-6 text-lg"
             v-for="(option, index) in question.answerList"
             :class="{'hover:bg-pink-100 cursor-pointer': selectedAnswer === ''},
                     {'bg-pink-300':selectedAnswer !== '' && selectedAnswer === option.answerIndex} "
             >
        <input type="radio"
               class="hidden"
               :id="index"
               :name="question.questionId"
               :value="option.answerIndex"
               v-model="selectedAnswer"
               @change="addAnswerToList($event)"/>
        <span>{{ option.answer }}</span>
      </label>
      <div class="mt-6 flow-root">
        <button class="float-right px-5 py-2 bg-pink-600 text-sm font-bold tracking-wide rounded-full"
                v-show="isAnswerSelected"
                v-if="isTestCompleted"
                @click="showResults">
          <span class="text-white">Show Results</span>
        </button>
        <button
            class="float-right px-5 py-2 bg-pink-600 text-sm font-bold tracking-wide rounded-full"
            v-show="isAnswerSelected"
            v-else
            @click="goToNextQuestion">
          <span class="text-white">Next Question</span>
        </button>
      </div>
    </div>

  </div>
</template>

<script>
import {useStore} from "vuex";
import {computed, ref} from "vue";
import {useRoute, useRouter} from 'vue-router';

export default {
  name: "QuestionComponent",
  props: {
    question: Object,
    listSize: Number
  },
  setup(props) {
    const store = useStore()
    const router = useRouter();
    let isTestCompleted = computed(() => store.state.quiz.isTestCompleted)
    let currentQuestionIndex = computed(() => store.state.quiz.currentQuestionIndex)
    let isAnswerSelected = computed(() => store.state.quiz.isAnswerSelected)
    let selectedAnswers = ref([])

    const selectedAnswer = ref('');
    function addAnswerToList (e){
      store.commit('quiz/fetchIsAnswerSelected', true)
      let answerIndex = e.target.value
      if(selectedAnswers.value[currentQuestionIndex.value] === undefined){
        selectedAnswers.value.push(answerIndex)
      }else {
        selectedAnswers.value.splice(currentQuestionIndex.value, 1)
        selectedAnswers.value.push(answerIndex)
      }
      store.commit('quiz/fetchSelectedAnswers', selectedAnswers)
    }
    function goToNextQuestion() {
      store.commit('quiz/fetchIsAnswerSelected', false)
      selectedAnswer.value = '';
      if (currentQuestionIndex.value < props.listSize - 1) {
        const nextQuestionIndex = currentQuestionIndex.value + 1
        store.commit('quiz/fetchCurrentQuestionIndex', nextQuestionIndex)
        return
      }
      if(currentQuestionIndex.value === props.listSize - 1){
        store.commit('quiz/fetchIsTestCompleted', true)
      }
    }

    function showResults() {
        router.push({
          name: 'Results'
        });
    }

    return {
      addAnswerToList,
      goToNextQuestion,
      showResults,
      isTestCompleted,
      isAnswerSelected,
      currentQuestionIndex,
      selectedAnswer
    }
  }
}
</script>

<style scoped>

</style>