<template>
<div id="asideBar">
    <el-tree :data="data" :props="defaultProps" @node-click="handleNodeClick"></el-tree>
</div>    
</template>

<script>
export default {
    name:"asideBar",
    data() {
      return {
        data: [{
          label: '一级 1',
          children: [{
            label: '二级 1-1',
            children: [{
              label: '三级 1-1-1'
            }]
          }]
        }, {
          label: '一级 2',
          children: [{
            label: '二级 2-1',
            children: [{
              label: '三级 2-1-1'
            }]
          }, {
            label: '二级 2-2',
            children: [{
              label: '三级 2-2-1'
            }]
          }]
        }, {
          label: '一级 3',
          children: [{
            label: '二级 3-1',
            children: [{
              label: '三级 3-1-1'
            }]
          }, {
            label: '二级 3-2',
            children: [{
              label: '三级 3-2-1'
            }]
          }]
        }],
        defaultProps: {
          children: 'children',
          label: 'label'
        }
      };
    },
    methods:{
        handleNodeClick(data) {
            window.console.log(data);
        }
    }
}
</script>

<style>
#asideBar{
  border-right: 1px solid black;
  height: 100%;
}
</style>
