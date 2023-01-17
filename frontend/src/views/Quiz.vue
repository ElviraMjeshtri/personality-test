<template>

  <QuestionComponent :question="getCurrentQuestion"
                     :list-size="getQuestionListSize"
  ></QuestionComponent>


</template>

<script>
import {computed} from 'vue'
import {useStore} from 'vuex'
import QuestionComponent from "@/component/QuestionComponent.vue";

export default {
  name: 'Quiz',
  components: {QuestionComponent},
  setup() {
    const store = useStore()
    store.dispatch('quiz/fetchQuestionList')
    const questionList = computed(() => store.state.quiz.questionDataList);
    let currentQuestionIndex = computed(() => store.state.quiz.currentQuestionIndex)

    const getCurrentQuestion = computed(() => {
      let question = questionList.value.questions[currentQuestionIndex.value];
      question.index = currentQuestionIndex.value
      return question
    });

    const getQuestionListSize = computed(() => {
      return questionList.value.questions.length
    });

    return {
      getCurrentQuestion,
      getQuestionListSize
    }
  }
}
</script>

<style scoped>

</style>