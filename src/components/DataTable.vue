<template>
<div id="dataTable">
    <el-table
    :data="tableData"
    border>
        <el-table-column
        prop="name"
        label="姓名">
        </el-table-column>
        <el-table-column
        prop="password"
        label="密码">
        </el-table-column>
        <el-table-column
        label="操作">
            <template slot-scope="scope">
                <el-button @click="removeUser(scope.row)">
                    Remove
                </el-button>
                <el-button @click="UpdateUser(scope.row)">
                    Update
                </el-button>
            </template>
        </el-table-column>
    </el-table>
</div>
</template>

<script>
import {globalbus} from './globalbus';
export default {
    name:"dataTable",
    data(){
        return {
            tableData:[]
        }
    },
    methods:{
        getData(){
            this.$axios.get()
            .then((response) => {
                this.tableData = response.data;    
            }).catch(function (response) {
                window.console.log(response)
            });
        },
        removeUser(row){
            let form =  new FormData();
            form.append('name', row.name);
            this.$axios.post("/remove", form)
                .then((response) => {
                    if (response.data==true)
                    {
                        window.console.log("success");
                        globalbus.$emit('datachanged', 'user removed')
                    }
                }).catch(function (response) {
                window.console.log(response)
            });
        },
        UpdateUser(row){

        }
    },
    mounted(){
        this.getData();
        globalbus.$on('datachanged', (a) => {
            window.console.log(a);
            this.getData();
        });
    }
}
</script>

<style>

</style>