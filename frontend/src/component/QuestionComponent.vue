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
               @change="addAnswerToList($event,currentQuestionIndex)">
        <span>{{ option.answer }}</span>
      </label>
    </div>
    <button v-if="isTestCompleted" @click="showResults">Show Results</button>
    <button v-else @click="goToNextQuestion">Next Question</button>
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
    let selectedAnswers = computed(() => store.state.selectedAnswers);
    let isTestCompleted = computed(() => store.state.isTestCompleted)
    let currentQuestionIndex = computed(() => store.state.currentQuestionIndex)
    function addAnswerToList (e, index){
      const answer = selectedAnswers.value[index];
      let points = e.target.value
      if(answer === undefined){
        selectedAnswers.value.push(points)
      }else {
        selectedAnswers.value.splice(index, 1)
        selectedAnswers.value.push(points)
      }
    }
    function goToNextQuestion() {
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
      isTestCompleted
    }
  }
}
</script>

<style scoped>

</style>