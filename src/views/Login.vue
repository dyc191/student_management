<script setup lang="ts">
import {ref} from "vue";
import axios from "axios";
import {ElMessage} from "element-plus";
import {useRouter} from "vue-router";

let router=useRouter()
let uname=ref("")
let upassword=ref("")

function login(){
  let user={
    uname:uname.value,
    upassword:upassword.value
  }

  axios.post("http://localhost:8080/login",user)
      .then(res=>{
        if(res.data){
          ElMessage.success("登录成功")
          router.push("/home")
        }
        else {
          ElMessage.error("登录失败")
        }
      })
}

</script>

<template>
  <div class="box">
    <h2>登录</h2>
    账号:<el-input
      v-model="uname"
      style="width: 240px"
      placeholder="Please input"
      clearable
  /> <br /> <br />
    密码:<el-input
      v-model="upassword"
      style="width: 240px"
      type="password"
      placeholder="Please input password"
      show-password
  /> <br /> <br />
    <el-button type="primary" round @click="login">登录</el-button>
  </div>

</template>

<style scoped>
.box{
  border: 1px solid #A9a9a9;
  width: 300px;
  height:240px;
  border-radius: 10px;
  margin: 170px auto;
  text-align: center;
}

</style>