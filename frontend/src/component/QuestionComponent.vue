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

export default {
  name: "QuestionComponent",
  props: {
    question: Object,
    listSize: Number
  },
  setup(props) {
    const store = useStore()
    let selectedAnswers = computed(() => store.state.selectedAnswers)
    let isTestCompleted = computed(() => store.state.isTestCompleted)
    let currentQuestionIndex = computed(() => store.state.currentQuestionIndex)
    let isAnswerSelected = computed(() => store.state.isAnswerSelected)

    const selectedAnswer = ref('');
    function addAnswerToList (e){
      store.commit('fetchIsAnswerSelected', true)
      const answer = selectedAnswers.value[currentQuestionIndex.value];
      let answerIndex = e.target.value
      if(answer === undefined){
        selectedAnswers.value.push(answerIndex)
      }else {
        selectedAnswers.value.splice(currentQuestionIndex.value, 1)
        selectedAnswers.value.push(answerIndex)
      }
    }
    function goToNextQuestion() {
      store.commit('fetchIsAnswerSelected', false)
      selectedAnswer.value = '';
      if (currentQuestionIndex.value < props.listSize - 1) {
        const nextQuestionIndex = currentQuestionIndex.value + 1
        store.commit('fetchCurrentQuestionIndex', nextQuestionIndex)
        return
      }
      if(currentQuestionIndex.value === props.listSize - 1){
        store.commit('fetchIsTestCompleted', true)
      }
    }

    function showResults() {

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