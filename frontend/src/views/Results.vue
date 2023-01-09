<template>
  <result-component :result="testResult.result"></result-component>
</template>

<script>
import {useStore} from "vuex";
import {computed} from "vue";
import ResultComponent from "@/component/ResultComponent.vue";

export default {
  name: "Results",
  components: {ResultComponent},
  setup() {
    const store = useStore()
    let selectedAnswers = computed(() => store.state.selectedAnswers)
    store.dispatch('fetchTestResult', selectedAnswers.value)
    const testResult = computed(() => store.state.result);
    return {
     testResult
    }
  }
}
</script>

<style scoped>

</style>