"use strict";

import Vue from 'vue';
import axios from "axios";
import router from '../router';
const jwt = require('jsonwebtoken');

// Full config:  https://github.com/axios/axios#request-config
// axios.defaults.baseURL = process.env.baseURL || process.env.apiUrl || '';
// axios.defaults.headers.common['Authorization'] = AUTH_TOKEN;
// axios.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded';

let config = {
  // baseURL: process.env.baseURL || process.env.apiUrl || ""
  // timeout: 60 * 1000, // Timeout
  // withCredentials: true, // Check cross-site Access-Control
    baseURL:"http://localhost:8080",
    headers:
    {
      'token':''
    }
};

const _axios = axios.create(config);

_axios.interceptors.request.use(
  function(config) {
    // Do something before request is sent
    let t = window.sessionStorage.getItem('token')
    if(jwt.verify(t,"vFg8z&L0t*y6rhQnWBWyMIRQCfWnS9wCa6yZcvMLpJphD$5AIdkPCnVmsAIO7ED0HgUoERR7iPxlrG!LMqd@C07FkleE4VpsMcG")){
      config.headers['token'] = t;
    }else{
      return 401;
    }
    return config;
  },
  function(error) {
    // Do something with request error
    return Promise.reject(error);
  }
);

// Add a response interceptor
_axios.interceptors.response.use(
  function(response) {
    // Do something with response data
      return response;
  },
  function(error) {
    // Do something with response error
    switch(error.status)
    {
      case 401:
        router.push('');
    }
    return Promise.reject(error);
  }
);

Plugin.install = function(Vue, options) {
  Vue.axios = _axios;
  window.axios = _axios;
  Object.defineProperties(Vue.prototype, {
    axios: {
      get() {
        return _axios;
      }
    },
    $axios: {
      get() {
        return _axios;
      }
    },
  });
};

Vue.use(Plugin)

export default Plugin;
