<template>
  <div class="place">
                    <h2 class="d-inline-flex"><em>Biblioteca</em></h2>
                    <h3 class="d-inline-flex"><em>Alunos</em></h3>
   <div class="left">
        <table class="tg">
        <th class="tg-yw4l">Id</th>
        <th class="tg-yw4l">Nome</th>
        <th class="tg-yw4l">CPF</th>
        <th class="tg-yw4l">Email</th>
        <th class="tg-yw4l">Ano</th>
        <th class="tg-yw4l">Periodo</th>
        <th class="tg-yw4l">Curso</th>
        <th class="tg-yw4l">Açao</th>
        
        <tr v-for="aluno in alunos" :key="aluno.id">
            <td class="tg-yw4l">{{ aluno.id }}</td>
            <td class="tg-yw4l">{{ aluno.nome }}</td>
            <td class="tg-yw4l">{{ aluno.cpf }}</td>
            <td class="tg-yw4l">{{ aluno.email }}</td>
            <td class="tg-yw4l">{{ aluno.ano }}</td>
            <td class="tg-yw4l">{{ aluno.periodoIngresso }}</td>
            <td class="tg-yw4l">{{ aluno.curso.nome }}</td>
          
            <td class="tg-yw4l">
                <button @click="remover(aluno.id)">Remover</button>
                <button @click="editar(aluno.id)">Editar</button>
            </td>   
            
        </tr>
    </table>
    </div>
    <div class="right">
    <form > 
           <div class="form-group">
                <label class="m-label">Nome</label>
                <input class="m-input" type="text" v-model='novoItem.nome' required >
            </div>
           <div class="form-group">
                <label class="m-label">Curso</label>
                <select class="m-input" v-model='novoItem.curso'>
                    <option v-bind:value="curso"  v-for="curso in cursos" :key="curso.id">{{curso.nome}}</option>
                </select>
            </div>
           <div class="form-group">
                <label class="m-label">Nome da mãe</label>
                <input class="m-input" type="text" v-model='novoItem.nomeMae' required >
            </div>
           <div class="form-group">
                <label class="m-label">Naturalidade</label>
                <input class="m-input" type="text" v-model='novoItem.naturalidade' required >
            </div>
           <div class="form-group">
                <label class="m-label">RG</label>
                <input class="m-input" type="text" v-model='novoItem.rg' required >
            </div>
           <div class="form-group">
                <label class="m-label">CPF</label>
                <input class="m-input" type="text" v-model='novoItem.cpf' required >
            </div>
           <div class="form-group">
                <label class="m-label">Endereço</label>
                <input class="m-input" type="text" v-model='novoItem.endereco' required >
            </div>
           <div class="form-group">
                <label class="m-label">Telefone</label>
                <input class="m-input" type="text" v-model='novoItem.telefone' required >
            </div>
           <div class="form-group">
                <label class="m-label">Ano</label>
                <input class="m-input" type="text" v-model='novoItem.ano' required >
            </div>
           <div class="form-group">
                <label class="m-label">Periodo</label>
                <input class="m-input" type="text" v-model='novoItem.periodoIngresso' required >
            </div>
           <div class="form-group">
                <label class="m-label">Email</label>
                <input class="m-input" type="text" v-model='novoItem.email' required >
            </div>
           <div class="form-group">
                <label class="m-label">Senha</label>
                <input class="m-input" type="password" v-model='novoItem.senha' required >
            </div>
            <div class="form-group"><button @click="add()"  v-if="modo=='list'">Salvar</button></div>
            <div class="form-group"><button @click="update()" v-if="modo=='update'">Atualizar</button></div>
    </form>
    </div>
  </div>
</template>
<script >
import axios from "axios";
export default {
  name: "Aluno",
  data() {
    return {
      novoItem: {},
      alunos: [],
      cursos: [],
      modo: "list",
      user: {}
    };
  },
  mounted() {
    if (sessionStorage.getItem("usr") == null) {
      this.$router.push("login");
    }
    this.buscar();
    this.user = JSON.parse(sessionStorage.getItem("usr"));
  },
  methods: {
    buscar() {
      axios.get("http://localhost:8090/aluno").then(res => {
        this.alunos = res.data;
      });
      axios.get("http://localhost:8090/curso").then(res => {
        this.cursos = res.data;
      });
    },
    editar(id) {
      this.modo = "update";
      axios
        .get("http://localhost:8090/aluno/" + id, this.novoItem)
        .then(res => {
          this.novoItem = res.data;
        });
    },
    remover(id) {
      this.modo = "list";
      axios({
        url: "http://localhost:8090/aluno/cpf/" + this.user.cpf + "/" + id,
        method: "DELETE",
        data: null
      }).then(res => {
        this.buscar();
      });
    },
    update() {
      axios.put("http://localhost:8090/aluno", this.novoItem).then(res => {
        this.modo = "list";
        this.novoItem = {};
        this.buscar();
      });
    },
    add() {
      axios
        .post("http://localhost:8090/aluno/cpf/" + this.user.cpf, this.novoItem)
        .then(res => {
          this.modo = "list";
          this.novoItem = {};
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
<style scoped>
.place {
  display: inline;
}
.left {
  overflow-y: scroll;
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

