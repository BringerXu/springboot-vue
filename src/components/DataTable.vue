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
export default {
    name:"dataTable",
    data(){
        return {
            tableData:[]
        }
    },
    methods:{

    },
    mounted(){
        this.$axios.get("http://127.0.0.1:8080")
        .then((response) => {
            this.tableData = response.data;
        }).catch(function (response) {
            window.console.log(response)
        });
    }
}
</script>

<style>

</style>