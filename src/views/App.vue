<template>
  <div id="app">
    <router-view>
    </router-view>
  </div>
</template>

<script>
import Login from '@/components/Login.vue'
import Backstage from '@/components/Backstage.vue'

export default {
  name: 'app',
  components: {
  }
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  box-sizing: border-box;
}
</style>
