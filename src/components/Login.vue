<template>
    <div id="login">
        <el-container>
            <el-main>
                <el-card id="logincard" shadow="hover">
                    <div slot="header" class="clearfix">
                        <span>单兵设备管理系统</span>
                    </div>
                    <div id="inputbox">
                        <span class="el-icon-user"></span><el-input v-model="name" placeholder="请输入内容"></el-input><br>    
                        <span class="el-icon-lock"></span><el-input placeholder="请输入密码" v-model="password" show-password></el-input>
                    </div>
                    <div id="cardFooter">
                        <el-button id=loginBtn :round=true @click="login">登录</el-button>
                    </div>    
                </el-card>
            </el-main>
        </el-container>
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
    background-color:#0F7DCC;
    height: 100%;
    width: 100%;
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

#login > section > main{
    padding:0;
}

#logincard{
    font-family:'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
    position: absolute;
    text-align: center;
    height: 300px;
    width: 400px;
    top: 50%;
    left: 50%;
    transform: translate(-50%,-50%);
    overflow: hidden;
    background: #5AA8DD;
    border: none;
    box-shadow: 0px 0px 8px rgb(49, 151, 219);
    opacity: 70%;
}

#inputbox > div{
    width: 80%;
    padding: 0 16px;
    text-align: center;
    margin: 5px;
}
#inputbox > div > input{
    background: transparent;
    border: none;
    border-bottom: 1px solid white;
    color: white;
}
#cardFooter{
    position: absolute;
    bottom: 2%;
    left: 0%;
    width: 100%;
}

#loginBtn
{
    width:80%;
    font-size: 20px;
    cursor: pointer;
    background-color: #0F7DCC;
    border: none;
    color:white;
}

#loginBtn:hover
{
    font-size: 22px;
    border: 1px solid #0F7DCC;

}
</style>