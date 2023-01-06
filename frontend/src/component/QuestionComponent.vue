<template>
  <section>
    <div class="quiz-info">
      <span class="question">{{ question.question }} </span>
    </div>
    <div class="options">
      <label v-for="(option, index) in question.answerList" key="index">
        <input type="radio"
               :id="index"
               :name="question.questionId"
               :value="option.points"
               v-model="selectedAnswer"
               @change="addAnswerToList($event)">
        <span>{{ option.answer }}</span>
      </label>
    </div>
    <button v-show="isAnswerSelected"  v-if="isTestCompleted" @click="showResults">Show Results</button>
    <button v-show="isAnswerSelected" v-else @click="goToNextQuestion">Next Question</button>
  </section>
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
      let points = e.target.value
      if(answer === undefined){
        selectedAnswers.value.push(points)
      }else {
        selectedAnswers.value.splice(currentQuestionIndex.value, 1)
        selectedAnswers.value.push(points)
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