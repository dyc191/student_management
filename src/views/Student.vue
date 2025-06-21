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
let dialogVisible=ref(false)

let updialogVisible=ref(false)

let stuname=ref()
let stusex=ref()
let stuage=ref()
let stuphone=ref()

let upstuid=ref()
let upstuname=ref()
let upstusex=ref()
let upstuage=ref()
let upstuphone=ref()

let searchstuid=ref()
let searchstuname=ref()

function refresh() {
  axios.get("http://localhost:8080/getall")
    .then(res => {
    tableData.value = res.data;
  })
}

function delstu(id){
  console.log(id)

  axios.get("http://localhost:8080/delstu?stuid="+id)
      .then(res=>{
        if(res.data>0){
          ElMessage.success("删除成功")
          refresh();
        }
        else{
          ElMessage.error("删除失败")
        }
      })
}

function resetvalue(){
  stuname.value='';
  stusex.value='';
  stuage.value='';
  stuphone.value='';
}

function addstu(){
  let obj={
    stuname:stuname.value,
    stusex:stusex.value,
    stuage:stuage.value,
    stuphone:stuphone.value,
  }
  if(obj.stuname==null|| obj.stusex==null|| obj.stuage==null|| obj.stuphone==null)//这里是判定为空是null，而不是""
  {
    alert("姓名、性别、年龄、电话不能为空")
  }
  else{
    axios.post("http://localhost:8080/addstu",obj)
      .then(res=>{
        if(res.data>0){
          ElMessage.success("添加成功")
          resetvalue()
          dialogVisible.value=false
          refresh()
        }
      })
  }
}

function updata(row){
  updialogVisible.value=true
  upstuid.value=row.stuid
  upstuname.value=row.stuname
  upstusex.value=row.stusex
  upstuage.value=row.stuage
  upstuphone.value=row.stuphone
}

function upstu(){
  let obj={
    stuid:upstuid.value,
    stuname:upstuname.value,
    stusex:upstusex.value,
    stuage:upstuage.value,
    stuphone:upstuphone.value
  }
  if(obj.stuname==""||obj.stusex==""||obj.stuage==""||obj.stuphone=="")//这里是判定为空是""，而不是null
  {
    alert("姓名、性别、年龄、电话不能为空")
  }
  else{
    axios.post("http://localhost:8080/upstu",obj)
        .then(res=>{
          if(res.data>0){
            ElMessage.success("修改成功")
            updialogVisible.value=false
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
  axios.post("http://localhost:8080/searchstu",obj)
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
  <el-button type="success" @click="dialogVisible=true">添加</el-button>
  <el-button type="info" @click="refresh">刷新</el-button>

  <el-dialog v-model="dialogVisible" title="添加学生" width="800">
    姓名: <el-input
      v-model="stuname"
      style="width: 240px"
      placeholder="Please input"
      clearable
  /><br />
    性别: <el-input
      v-model="stusex"
      style="width: 240px"
      placeholder="Please input"
      clearable
  /><br />
    年龄: <el-input
      v-model="stuage"
      style="width: 240px"
      placeholder="Please input"
      clearable
  /><br />
    电话: <el-input
      v-model="stuphone"
      style="width: 240px"
      placeholder="Please input"
      clearable
  /><br />
    <el-button type="success" @click="addstu">确认添加</el-button>


  </el-dialog>

  <el-dialog v-model="updialogVisible" title="修改学生信息" width="800">
    姓名: <el-input
      v-model="upstuname"
      style="width: 240px"
      placeholder="Please input"
      clearable
  /><br />
    性别: <el-input
      v-model="upstusex"
      style="width: 240px"
      placeholder="Please input"
      clearable
  /><br />
    年龄: <el-input
      v-model="upstuage"
      style="width: 240px"
      placeholder="Please input"
      clearable
  /><br />
    电话: <el-input
      v-model="upstuphone"
      style="width: 240px"
      placeholder="Please input"
      clearable
  /><br />
    <el-button type="success" @click="upstu">确认修改</el-button>


  </el-dialog>


  <el-table :data="tableData" style="width: 100%">
    <el-table-column fixed prop="stuid" label="学号" width="150" />
    <el-table-column prop="stuname" label="姓名" width="120" />
    <el-table-column prop="stusex" label="性别" width="120" />
    <el-table-column prop="stuage" label="年龄" width="120" />
    <el-table-column prop="stuphone" label="电话" width="120" />
    <el-table-column prop="imgpath" label="图片地址" width="120" />
    <el-table-column  label="Operations" min-width="120">
      <template #default="scope">
        <el-button link type="primary" size="small" @click="delstu(scope.row.stuid)">
          删除
        </el-button>
        <el-button link type="primary" size="small" @click="updata(scope.row)">
          修改
        </el-button>
      </template>
    </el-table-column>

  </el-table>


</template>

<style scoped>

</style>