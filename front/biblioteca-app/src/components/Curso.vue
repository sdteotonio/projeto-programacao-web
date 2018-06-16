<template>
  <div class="place">
                    <h2 class="d-inline-flex"><em>Biblioteca</em></h2>
                    <h3 class="d-inline-flex"><em>Cursos</em></h3>
   <div class="left">
        <table class="tg">
        <th class="tg-yw4l">Id</th>
        <th class="tg-yw4l">Nome</th>
        <th class="tg-yw4l">Area</th>
        <th class="tg-yw4l">Nível</th>
        <th class="tg-yw4l">Açao</th>
        <tr v-for="curso in cursos" :key="curso.id">
            <td class="tg-yw4l">{{ curso.id }}</td>
            <td class="tg-yw4l">{{ curso.nome }}</td>
            <td class="tg-yw4l">{{ curso.area }}</td>
            <td class="tg-yw4l">{{ curso.nivel }}</td>
            <td class="tg-yw4l">
                <button @click="remover(curso.id)">Remover</button>
                <button @click="editar(curso.id)">Editar</button>
            </td>
        </tr>
    </table>
    </div>
    <div class="right">
    <form > 
        <label class="m-label"> Nome</label>
            <div class="form-group">
                <input  class="m-input" type="text" v-model='novoCurso.nome' placeholder="Nome" required >
            </div>
        <label class="m-label" >Area</label>
            <div class="form-group">
                <input class="m-input" type="text" v-model='novoCurso.area' placeholder="Area" required >
            </div>
        <label class="m-label" >Nível</label>
        <div class="form-group">
            <select class="m-input" v-model='novoCurso.nivel' required >
                <option value="GRADUACAO">Graduação</option>
                <option value="ESPECIALIZACAO">Especializacao</option>
            </select>
        </div>
            <div class="form-group"><button @click="addCurso()"  v-if="modo=='list'">Salvar</button></div>
            <div class="form-group"><button @click="update()" v-if="modo=='update'">Atualizar</button></div>
    </form>
    </div>
  </div>
</template>
<script >
import axios from "axios";
export default {
  name: "Curso",
  data() {
    return {
      novoCurso: {},
      cursos: [],
      modo: "list",
      user: {}
    };
  },
  mounted() {
    if (sessionStorage.getItem("usr") == null) {
      this.$router.push("login");
    }
    axios.get("http://localhost:8090/curso").then(res => {
      this.cursos = res.data;
    });
    this.user = JSON.parse(sessionStorage.getItem("usr"));
  },
  methods: {
    buscar() {
      axios.get("http://localhost:8090/curso").then(res => {
        this.cursos = res.data;
      });
    },
    editar(id) {
      this.modo = "update";
      axios
        .get("http://localhost:8090/curso/" + id, this.novoCurso)
        .then(res => {
          this.novoCurso = res.data;
        });
    },
    remover(id) {
      this.modo = "list";
      axios({
        url: "http://localhost:8090/curso/cpf/" + this.user.cpf + "/" + id,
        method: "DELETE",
        data: null
      }).then(res => {
        this.buscar();
      });
    },
    update() {
      axios
        .put(
          "http://localhost:8090/curso/cpf/" +
            this.user.cpf +
            "/" +
            this.novoCurso.id,
          this.novoCurso
        )
        .then(res => {
          this.modo = "list";
          this.novoCurso = {};
          this.buscar();
        });
    },
    addCurso() {
      axios
        .post(
          "http://localhost:8090/curso/cpf/" + this.user.cpf,
          this.novoCurso
        )
        .then(res => {
          this.modo = "list";
          this.novoCurso = {};
          this.buscar();
        });
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
<style>
.place {
  display: inline;
}
.left {
  width: 50%;
  float: left;
}
.right {
  width: 50%;
  float: left;
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

  word-break: normal;
  border-color: black;
}
.tg .tg-yw4l {
  vertical-align: top;
}
.m-label,
.m-input {
  display: flex;
}
</style>

