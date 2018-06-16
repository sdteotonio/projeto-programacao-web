<template>
  <div>
  <div class="d-flex align-items-center align-content-center align-self-center div-name-ufab">
                    <h2 class="d-inline-flex"><em>Biblioteca</em></h2>
                    <h3 class="d-inline-flex"><em>Alunos</em></h3>
        </div>
  </div>
</template>
<script >
import axios from "axios";
export default {
  name: "Aluno",
  data() {
    return {};
  },
  mounted() {
    if (sessionStorage.getItem("usr") == null) {
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
</style>
