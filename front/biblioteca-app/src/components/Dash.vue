<template>
  <div>
       <div class="d-flex align-items-center align-content-center align-self-center div-name-ufab">
                    <h2 class="d-inline-flex"><em>Biblioteca</em></h2>
                    <h3 class="d-inline-flex"><em>Dashboard</em></h3>
        </div>
    <div>
        <router-link :to="{ name: 'curso'}">Cursos</router-link>

    </div>
    <div>
       <router-link :to="{ name: 'aluno'}">Alunos</router-link>

    </div>
    <div>
        <router-link :to="{ name: 'item'}">Itens</router-link>

    </div>
    <div>
        <a v-on:click="logOut()">Sair</a>
    </div>
  </div>
</template>
<script >
import axios from "axios";
export default {
  name: "Dash",
  data() {
    return {};
  },
  mounted() {
    if (sessionStorage.getItem("usr") == null) {
      this.$router.push("login");
    }
  },
  methods: {
    logOut() {
      sessionStorage.clear();
      this.$router.push("login");
    }
  }
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h1,
h2 {
  font-weight: normal;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
.tg {
  border-collapse: collapse;
  border-spacing: 0;
}
.tg td {
  font-family: Arial, sans-serif;
  font-size: 14px;
  padding: 10px 5px;
  border-style: solid;
  border-width: 1px;
  overflow: hidden;
  word-break: normal;
  border-color: black;
}
.tg th {
  font-family: Arial, sans-serif;
  font-size: 14px;
  font-weight: normal;
  padding: 10px 5px;
  border-style: solid;
  border-width: 1px;
  overflow: hidden;
  word-break: normal;
  border-color: black;
}
.tg .tg-yw4l {
  vertical-align: top;
}
</style>
