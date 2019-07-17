import Vue from 'vue'
import App from './views/App.vue'
import router from './router'
import './plugins/axios'
import './plugins/element.js'
import 'animate.css'

Vue.config.productionTip = false
let jwt = require('jsonwebtoken');
router.beforeEach((to, from, next) => {
  // to and from are both route objects. must call `next`.
  if (to.path != "/") {
    try {
      var j = jwt.verify(window.sessionStorage.getItem("token"),"vFg8z&L0t*y6rhQnWBWyMIRQCfWnS9wCa6yZcvMLpJphD$5AIdkPCnVmsAIO7ED0HgUoERR7iPxlrG!LMqd@C07FkleE4VpsMcG");
      window.console.log(j);
      next()
    } catch (error) {
      window.console.log(error)
      next({path: "/"})
    }
  } else {
    next()
  }
})

new Vue({
  router,
  render: h => h(App)
}).$mount('#app')
