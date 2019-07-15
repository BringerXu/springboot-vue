<template>
    <div id="login">
        <el-container>
            <el-main>
                <el-card id="logincard" shadow="hover">
                    <div slot="header" class="clearfix">
                        <span>单兵设备管理系统</span>
                    </div>
                    <div id="inputbox">
                        <el-input v-model="name" placeholder="请输入内容"></el-input>
                        <el-input placeholder="请输入密码" v-model="password" show-password></el-input>
                    </div>
                    <div id="cardFooter">
                        <el-button id=loginBtn :round=true @click="login">登录</el-button>
                    </div>
                    
                </el-card>
            </el-main>
        </el-container>
        <img id="loginBg" src="../assets/bg01v2.jpg" alt="">
    </div>    
</template>

<script>
export default {
    name:'Login',
    data()
    {
        return{
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
                    response.data? this.$router.push('backstage'):this.$message("账号或密码错误");
                }).catch(function (response){
                    window.console.log(response)
                });
        }
    }
}
</script>

<style>
#login
{
    margin:0;
    padding:0;
}

#loginBg
{
    position: absolute;
    left: 0;
    top: 0;
    opacity: 80%;
    z-index: -99;
    width: 100%;
    height: 100%;
    opacity: 80%;
}

#login > section > main{
    padding:0;
}

#logincard > div.el-card__header > div > span
{
    font-size: 30px;
    font-family: 'Courier New', Courier, monospace, cursive;
    font-weight: 800;
    color: #fff;
}

#logincard{
    font-family:'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
    position: absolute;
    text-align: center;
    height: 500px;
    width: 500px;
    top: 50%;
    left: 50%;
    transform: translate(-50%,-50%);
    overflow: hidden;
    background-image: url(../assets/bg02.jpg)
}

#inputbox{
    position: absolute;
}

#inputbox > div{
    width: 80%;
    padding: 0 16px;
    text-align: center;
    margin: 5px;
}

#cardFooter{
    position: absolute;
    bottom: 5%;
    left: 50%;
    transform:translate(-50%)
}
</style>