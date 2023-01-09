<template>
  <div class="flex max-w-5xl justify-center items-center h-screen">
    <div class="shadow-pink-300 p-12 rounded-lg shadow-lg w-full mt-8 bg-white content-center">
      <h1 class="pb-10  font-bold text-5xl text-center text-pink-600"> {{result.title}}</h1>
      <p class="text-lg">
        {{result.description}}
      </p>
      <div class="flex flex-col items-center justify-center pt-4">
        <button
            class="px-10 py-2 bg-pink-600 text-sm font-bold tracking-wide rounded-full"
            @click="retakeQuiz">
          <span class="text-white">Retake Quiz</span>
        </button>
      </div>
    </div>
  </div>
</template>
<script>
import {useStore} from "vuex";
import {useRouter} from "vue-router";

export default {
  name: "ResultComponent",
  props: {
    result: Array
  },
  setup(){
    const store = useStore()
    const router = useRouter();
    function retakeQuiz() {
     store.commit("resetState")
      router.push({
        name: 'Quiz'
      });
    }
    return{
      retakeQuiz
    }
  }
}
</script>

<style scoped>

</style>