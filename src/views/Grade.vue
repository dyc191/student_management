<script setup lang="ts">
import {onMounted} from "vue";
import { Delete, Edit, Search, Share, Upload } from '@element-plus/icons-vue'
import axios from "axios";
import {ref} from "vue";
import {ElMessage} from "element-plus";

//mounted钩子，页面加载时获取数据
onMounted(()=>{
  refresh()
})

let tableData=ref([])

let updialogVisible=ref(false)

let upstuid=ref()
let upstuname=ref()
let upgrade=ref()
let upcredit=ref()
let upgradepoint=ref()

let searchstuid=ref()
let searchstuname=ref()

function refresh() {
  axios.get("http://localhost:8080/getallgrade")
      .then(res => {
        tableData.value = res.data;
      })
}

function updata(row){
  updialogVisible.value=true
  upstuid.value=row.stuid
  upstuname.value=row.stuname
  upgrade.value=row.grade
  upcredit.value=row.credit
  upgradepoint.value=row.gradepoint
}

function upgra() {
  let obj = {
    stuid: upstuid.value,
    stuname: upstuname.value,
    grade: upgrade.value,
    credit: upcredit.value,
    gradepoint: upgradepoint.value
  }
  if (obj.grade == "" || obj.grade > 100) {
    alert("成绩输入错误")
  } else {
    axios.post("http://localhost:8080/upgrade", obj)
        .then(res => {
          if (res.data > 0) {
            ElMessage.success("修改成功")
            updialogVisible.value = false
            refresh()
          }
        })
   }
  }

function search(){
  let obj={
    stuid:searchstuid.value,
    stuname:searchstuname.value
  }
  axios.post("http://localhost:8080/searchgrade",obj)
      .then(res=>{
        tableData.value=res.data;
      })
}


</script>

<template>
  学号:<el-input
    v-model="searchstuid"
    style="width: 240px"
    placeholder="Please input"
    clearable
/>
  姓名:<el-input
    v-model="searchstuname"
    style="width: 240px"
    placeholder="Please input"
    clearable
/>

  <el-button type="primary" :icon="Search" @click="search">Search</el-button>
  <el-button type="info" @click="refresh">刷新</el-button>

  <el-dialog v-model="updialogVisible" title="修改学生成绩" width="800">
    学号: <el-input
      v-model="upstuid"
      style="width: 240px"
      disabled
      placeholder="Please input"
  /><br />
    姓名: <el-input
      v-model="upstuname"
      style="width: 240px"
      disabled
      placeholder="Please input"
  /><br />
    成绩: <el-input
      v-model="upgrade"
      style="width: 240px"
      placeholder="Please input"
      clearable
  /><br />
    学分: <el-input
      v-model="upcredit"
      style="width: 240px"
      disabled
      placeholder="Please input"
  /><br />
    绩点: <el-input
      v-model="upgradepoint"
      style="width: 240px"
      disabled
      placeholder="Please input"
  /><br />
    <el-button type="success" @click="upgra">确认修改</el-button>


  </el-dialog>


  <el-table :data="tableData" style="width: 100%">
    <el-table-column fixed prop="stuid" label="学号" width="150" />
    <el-table-column prop="stuname" label="姓名" width="120" />
    <el-table-column prop="grade" label="成绩" width="120" />
    <el-table-column prop="credit" label="学分" width="120" />
    <el-table-column prop="gradepoint" label="绩点" width="120" />
    <el-table-column  label="Operations" min-width="120">
      <template #default="scope">
        <el-button link type="primary" size="small" @click="updata(scope.row)">
          修改
        </el-button>
      </template>
    </el-table-column>

  </el-table>


</template>

<style scoped>

</style>