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
            </template>
        </el-table-column>
    </el-table>
    <el-pagination @current-change="handleCurrentChange"
        :current-page.sync="currentPage" :page-size="pagesize" layout=" prev, pager, next,total"
        :total="totalnum" background >
    </el-pagination>
</div>
</template>

<script>
import {globalbus} from './globalbus';
export default {
    name:"dataTable",
    data(){
        return {
            tableData:[],
            currentPage:1,
            pagesize:10,
            totalnum:0
        }
    },
    methods:{
        getData(){
            this.getTotal();
            this.getTable(1);
        },
        getTotal(){
            this.$axios.get()
            .then((response) => {
                this.totalnum = response.data;    
                }).catch(function (response) {
                    window.console.log(response)
                    });
        },
        getTable(val){
            this.currentPage = val;
            let form = new FormData();
            form.append('pageNum', val)
            form.append('pageSize', this.pagesize)
            this.$axios.post("", form)
            .then((response) => {
                this.tableData = response.data;    
            }).catch(function (response) {
                window.console.log(response)
            });
        },
        handleCurrentChange(val) {
            this.getTable(val);
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