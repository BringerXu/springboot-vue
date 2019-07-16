<template>
    <div id="searchBar">
        <el-row>
            <el-col :span="8"><el-input v-model="name" placeholder="请输入添加用户姓名"></el-input></el-col>
            <el-col :span="8"><el-input v-model="password" placeholder="请输入添加用户密码"></el-input></el-col>
            <el-col :span="8"><el-button @click="addUser">Add</el-button></el-col>
        </el-row>
        <el-row>
            <el-col :span="8"><el-input v-model="d_name" placeholder="请输入删除用户姓名"></el-input></el-col>
            <el-col :span="8"><el-button @click="removeUser">Remove</el-button></el-col>
        </el-row>
        
    </div>
</template>

<script>
import {globalbus} from './globalbus';
export default {
    name:"searchBar",
    data(){
        return {
            name:'',
            password:'',
            d_name:''
        }
    },
    methods:{
        clearInput(){
            this.name='';
            this.password='',
            this.d_name=''
        },
        addUser(){
            let form =  new FormData();
            form.append('name',this.name);
            form.append('password',this.password);
            this.$axios.post("http://127.0.0.1:8080/add", form)
                .then((response) => {
                    // this.type_options = response.data;
                    if (response.data==true)
                    {
                        window.console.log("success");     
                        globalbus.$emit('datachanged', 'user added')
                    }
                    this.clearInput();
                }).catch(function (response) {
                window.console.log(response)
            });
        },
        removeUser(){
            let form =  new FormData();
            form.append('name', this.d_name);
            this.$axios.post("http://127.0.0.1:8080/remove", form)
                .then((response) => {
                    // this.type_options = response.data;
                    if (response.data==true)
                    {
                        window.console.log("success");
                        globalbus.$emit('datachanged', 'user removed')
                    }
                    this.clearInput();
                }).catch(function (response) {
                window.console.log(response)
            });
        }
    }
}
</script>

<style>

</style>