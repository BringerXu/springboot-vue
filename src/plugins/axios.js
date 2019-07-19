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
    if(config.url == '/login'){
      return config;
    }else{
      let t = window.sessionStorage.getItem('token');
      jwt.decode(t);
      config.headers['token'] = t;
      return config;
    }
  },
  function(error) {
    // Do something with request error
    window.sessionStorage.setItem('token', '');
    router.push('/');
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
    window.sessionStorage.setItem('token', '');
    router.push('/');
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
