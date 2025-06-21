<script setup lang="ts">

</script>

<template>
  <div class="common-layout">
    <el-container>
      <el-header>学生管理系统</el-header>
      <el-container>
        <el-aside width="200px">
          <el-menu
              default-active="2"
              class="el-menu-vertical-demo"
              router
          >
            <el-menu-item index="/student">
              <el-icon><House /></el-icon>
              <span>学生信息管理</span>
            </el-menu-item>
            <el-menu-item index="/grade" >
              <el-icon><document /></el-icon>
              <span>学生成绩管理</span>
            </el-menu-item>
          </el-menu>
        </el-aside>
        <el-main>
          <router-view> </router-view>
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>

<style scoped>
.el-header{
  background-color: #B3C0D1;
  color: #333;
  text-align: center;
  line-height: 60px;
  font-size: 30px;
}

.el-aside {
  background-color: #D3DCE6;
  color: #333;
  text-align: center;
  line-height: 200px;
  height: 900px;
}

.el-main {
  background-color: #E9EEF3;
  color: #333;
  text-align: center;
  line-height: 60px;
}

body > .el-container {
  margin-bottom: 40px;
}
</style>
