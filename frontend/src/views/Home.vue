<template>
  <div class="flex justify-center items-center h-screen">
    <div class="bg-white p-10">
      <h1 class="font-bold text-5xl text-center text-pink-600 pb-10">
        Welcome to personality test Elvira Mjeshtri
      </h1>
      <div class="block mt-4 border border-pink-200 text-white rounded-lg py-2
       px-6 text-lg text-center bg-pink-600 hover:bg-fuchsia-400 cursor-pointer">
        <router-link to="/quiz">Start quiz</router-link>
      </div>
    </div>
  </div>

</template>

<script>
export default {
  name: "Home"
}
</script>

<style scoped>

</style>