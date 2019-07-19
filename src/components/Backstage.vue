<template>
    <div id="Backstage">
        <el-container>
            <el-header>
                <span>单兵设备管理系统</span>
            </el-header>
            <el-container>
                <el-aside>
                    <AsideBar/>
                </el-aside>
                <el-main>
                    <SearchBar ref="searchBar"/>
                    <DataTable ref="dataTable"/>
                </el-main>
            </el-container>
            <el-footer></el-footer>
        </el-container>
    </div>
</template>

<script>
import DataTable from '@/components/DataTable.vue'
import AsideBar from '@/components/AsideBar.vue'
import SearchBar from '@/components/SearchBar.vue'
export default {
    name: 'Backstage',
    components:{
        AsideBar,
        SearchBar,
        DataTable
    },
}
</script>

<style>
#Backstage{
    height: 100%;
}

#Backstage > section
{
    height: 100%;
}

#Backstage > section > header{
    /* background-color: cornflowerblue; */
    /* background-clip:border-box; */
    background-attachment: fixed;
    background-image: url("../assets/bg01v2.jpg")
}

#Backstage > section > header > span{
    position: absolute;
    left: 50%;
    transform: translate(-50%);
    color:aliceblue;
    text-align: center;
    vertical-align: middle;
    font-size: 22px;
    top: 10px;
    text-shadow: 5px 5px 5px black;
}
</style>
