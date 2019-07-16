<template>
  <div id="app">
    <transition name="slide-left">
      <router-view></router-view>
    </transition>
  </div>
</template>

<script>

export default {
  name: 'app',
}
</script>

<style >
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  padding:0;
  margin:0;
  height:100%;
  width:100%;
}


/* router view 转场动画 */
.slide-left-enter{
    opacity:0;
    transform: translate3d(100%,0,0)
}

.slide-left-enter-active{
    transition: all 300ms  
}

.slide-left-leave-to{
    opacity:0;
    transition: translate3d(-100%,0,0)  
}
</style>
