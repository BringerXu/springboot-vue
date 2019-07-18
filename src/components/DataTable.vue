<template>
<div id="dataTable">
    <el-table
    :data="tableData">
        <el-table-column
        prop="name"
        label="姓名">
        </el-table-column>
        <el-table-column
        prop="password"
        label="密码">
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