<template>
    <div>
        <el-container>
            <el-header>Header</el-header>
            <el-container>
                <el-aside width="200px">Aside</el-aside>
                <el-main>
                    <el-input v-model="name" placeholder="请输入内容"></el-input>
                    <el-input placeholder="请输入密码" v-model="password" show-password></el-input>
                    <el-button type="primary" :loading="Loading" @click="login">登录</el-button>
                </el-main>
            </el-container>
        </el-container>
    </div>    
</template>

<script>
export default {
    name:'Login',
    data()
    {
        return{
            Loading:false,
            name:"",
            password:"",
        }
    },
    methods:{
        login()
        {
            let form =  new FormData();
            form.append("name", this.name)
            form.append("password", this.password)
            this.$axios.post("http://127.0.0.1:8080/login", form)
                .then((response) => 
                {
                    response.data? this.$router.push('backstage'):false;
                }).catch(function (response){
                    window.console.log(response)
                });
        }
    }
}
</script>

