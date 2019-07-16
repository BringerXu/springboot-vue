<template>
    <div id="Backstage">
        <el-container>
            <el-header>
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

</style>
