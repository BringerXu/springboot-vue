<template>
    <div id="Backstage">
        <div>
            {{Table}}
            <button @click="login">
                click
            </button>
        </div>

        <div>
            <button @click="adduser">
                click2
            </button>
        </div>

        <div>
            <button @click="removeuser">
                click3
            </button>
        </div>
    </div>
</template>

<script>
export default {
    name: 'Backstage',
    data(){
        return {
            Table:[],
            name:"",
            password:"",
        }
        
    },
    methods:{
        login(){
            this.$axios.get("http://127.0.0.1:8080")
                .then((response) => {
                    // this.type_options = response.data;
                    this.Table = response.data;
                }).catch(function (response) {
                window.console.log(response)
            });
        },
        adduser(){
            let form =  new FormData();
            form.append('name','la');
            form.append('password','181818');
            this.$axios.post("http://127.0.0.1:8080/add", form)
                .then((response) => {
                    // this.type_options = response.data;
                    if (response.data==true)
                    {
                        this.login()
                    }
                }).catch(function (response) {
                window.console.log(response)
            });
        },
        removeuser(){
            let form =  new FormData();
            form.append('name','la');
            this.$axios.post("http://127.0.0.1:8080/remove", form)
                .then((response) => {
                    // this.type_options = response.data;
                    if (response.data==true)
                    {
                        this.login()
                    }
                }).catch(function (response) {
                window.console.log(response)
            });
        }
    }
}
</script>

<style>

</style>
