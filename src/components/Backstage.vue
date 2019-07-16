<template>
    <div id="Backstage">
        <el-container>
            <el-header>
            </el-header>
            <el-container>
                <el-aside>
                    aside
                </el-aside>
                <el-main>
                    <DataTable/>
                </el-main>
            </el-container>
            <el-footer></el-footer>
        </el-container>
    </div>
</template>

<script>
import DataTable from '@/components/DataTable.vue'
export default {
    name: 'Backstage',
    components:{
        DataTable
    },
    data(){
        return {
            name:"",
            password:"",
        }
        
    },
    methods:{
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
