<template>
  <div class="place">
                    <h2 class="d-inline-flex"><em>Biblioteca</em></h2>
                    <h3 class="d-inline-flex"><em>Itens</em></h3>
   <div class="left">
        <table class="tg">
        <th class="tg-yw4l">Id</th>
        <th class="tg-yw4l">Tipo de item</th>
        <th class="tg-yw4l">Tipo de anais de congresso</th>
        <th class="tg-yw4l">Tipo de midia</th>
        <th class="tg-yw4l">Tipo de trabalho</th>
        <th class="tg-yw4l">ISBN</th>
        <th class="tg-yw4l">Titulo</th>
        <th class="tg-yw4l">Autor</th>
        <th class="tg-yw4l">Congresso</th>
        <th class="tg-yw4l">Ano de publicacao</th>
        <th class="tg-yw4l">Local</th>
        <th class="tg-yw4l">Editora</th>
        <th class="tg-yw4l">Edição</th>
        <th class="tg-yw4l">Número de paginas</th>
        <th class="tg-yw4l">Área</th>
        <th class="tg-yw4l">Tema</th>
        <th class="tg-yw4l">Data de gravação</th>
        <th class="tg-yw4l">Orientador</th>
        <th class="tg-yw4l">Data</th>
        <th class="tg-yw4l">Quantidade</th>
 
        <th class="tg-yw4l">Açao</th>
        
        <tr v-for="item in itens" :key="item.id">
            <td class="tg-yw4l">{{ item.id }}</td>
            <td class="tg-yw4l">{{ item.tipoItem }}</td>
            <td class="tg-yw4l">{{ item.tipoAnais }}</td>
            <td class="tg-yw4l">{{ item.tipoMidia }}</td>
            <td class="tg-yw4l">{{ item.tipoTrabalho }}</td>
            <td class="tg-yw4l">{{ item.isbn }}</td>
            <td class="tg-yw4l">{{ item.titulo }}</td>
            <td class="tg-yw4l">{{ item.autor }}</td>
            <td class="tg-yw4l">{{ item.congresso }}</td>
            <td class="tg-yw4l">{{ item.anoPublicacao }}</td>
          <td class="tg-yw4l">{{ item.local }}</td>
            <td class="tg-yw4l">{{ item.editora }}</td>
            <td class="tg-yw4l">{{ item.edicao }}</td>
            <td class="tg-yw4l">{{ item.numeroPagina }}</td>
            <td class="tg-yw4l">{{ item.area }}</td>
            <td class="tg-yw4l">{{ item.tema }}</td>
            <td class="tg-yw4l">{{ item.dataGravacao }}</td>
            <td class="tg-yw4l">{{ item.orientador }}</td>
            <td class="tg-yw4l">{{ item.data }}</td>
            <td class="tg-yw4l">{{ item.quantidade }}</td>
            <td class="tg-yw4l">
                <button @click="remover(item.id)">Remover</button>
                <button @click="editar(item.id)">Editar</button>
            </td>   
            
        </tr>
    </table>
    </div>
    <div class="right">
    <hr>
    <form > 
        <label class="m-label"> Tipo de item</label>
           <div class="form-group">
                <select class="m-input" v-model='novoItem.tipoItem' required >
                    <option value="ANAIS">Anais de Congresso</option>
                    <option value="JORNAL">Jornal</option>
                    <option value="LIVRO">Livro</option>
                    <option value="MIDIA">Midia digital</option>
                    <option value="REVISTA">Revista</option>
                    <option value="TRABALHOCONCLUSAO">TCC</option>
                </select>
            </div>
           <div class="form-group" v-if="novoItem.tipoItem=='ANAIS'">
                <label class="m-label"> Tipo de anais de congresso</label>
                <select class="m-input" v-model='novoItem.tipoAnais' required >
                    <option value="ARTIGO">Artigo</option>
                    <option value="POSTER">Poster</option>
                    <option value="RESUMO">Resumo</option>
                    <option value="NONE">None</option>
                </select>
            </div>
           <div class="form-group" v-if="novoItem.tipoItem=='MIDIA'">
                <label class="m-label"> Tipo de midia</label>
                <select class="m-input" v-model='novoItem.tipoMidia' required >
                    <option value="ARTIGO">Artigo</option>
                    <option value="POSTER">Poster</option>
                    <option value="RESUMO">Resumo</option>
                </select>
            </div>
           <div class="form-group" v-if="novoItem.tipoItem=='TRABALHOCONCLUSAO'">
                <label class="m-label" > Tipo de trabalho</label>
                <select class="m-input" v-model='novoItem.tipoTrabalho' required >
                    <option value="MONOGRAFIA">Monografia</option>
                    <option value="DISSERTACAO">Dissertação</option>
                    <option value="TESE">Tese</option>
                </select>
            </div>
            <div class="form-group"  v-if="novoItem.tipoItem=='LIVRO'">
        <label class="m-label" >ISBN</label>
                <input class="m-input" type="text" v-model='novoItem.isbn' required >
            </div>
        <label class="m-label">Titulo</label>
            <div class="form-group">
                <input class="m-input" type="text" v-model='novoItem.titulo' required >
            </div>
        <label class="m-label" >Autor</label>
            <div class="form-group">
                <input class="m-input" type="text" v-model='novoItem.autor' required >
            </div>
            <div class="form-group"  v-if="novoItem.tipoItem=='ANAIS'">
        <label class="m-label">Congresso</label>
                <input class="m-input" type="text" v-model='novoItem.congresso' required >
            </div>
            <div class="form-group" v-if="novoItem.tipoItem=='ANAIS' | 'LIVRO'">
        <label class="m-label">Ano de publicacao</label>
                <input class="m-input" type="text" v-model='novoItem.anoPublicacao' required >
            </div>
        
            <div class="form-group" v-if="novoItem.tipoItem=='ANAIS'">
        <label class="m-label"  >Local</label>
                <input class="m-input" type="text" v-model='novoItem.local' required >
            </div>
            <div class="form-group"  v-if="novoItem.tipoItem=='LIVRO'">
        <label class="m-label">Editora</label>
                <input class="m-input" type="text" v-model='novoItem.editora' required >
            </div>
            <div class="form-group" v-if="novoItem.tipoItem=='JORNAL' | 'LIVRO'">
        <label class="m-label"  >Edição</label>
                <input class="m-input" type="text" v-model='novoItem.edicao' required >
            </div>
            <div class="form-group"  v-if="novoItem.tipoItem=='LIVRO'">
        <label class="m-label" >Número de paginas</label>
                <input class="m-input" type="text" v-model='novoItem.numeroPagina' required >
            </div>
            <div class="form-group"  v-if="novoItem.tipoItem=='LIVRO'">
        <label class="m-label">Área</label>
                <input class="m-input" type="text" v-model='novoItem.area' required >
            </div>
            <div class="form-group"  v-if="novoItem.tipoItem=='LIVRO'">
        <label class="m-label">Tema</label>
                <input class="m-input" type="text" v-model='novoItem.tema' required >
            </div>
            <div class="form-group" v-if="novoItem.tipoItem=='MIDIA'">
        <label class="m-label">Data de gravação</label>
                <input class="m-input" type="text" v-model='novoItem.dataGravacao' required >
            </div>
            <div class="form-group" v-if="novoItem.tipoItem=='TRABALHOCONCLUSAO'">
        <label class="m-label">Orientador</label>
                <input class="m-input" type="text" v-model='novoItem.orientador' required >
            </div>
            <div class="form-group" v-if="novoItem.tipoItem=='JORNAL' | 'TRABALHOCONCLUSAO'">
            <label class="m-label" >Data</label>
                <input class="m-input" type="text" v-model='novoItem.data' required >
            </div>
        <label class="m-label">Quantidade</label>
            <div class="form-group">
                <input class="m-input" type="text" v-model='novoItem.quantidade' required >
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
  name: "Item",
  data() {
    return {
      novoItem: {},
      itens: [],
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
      axios.get("http://localhost:8090/item").then(res => {
        this.itens = res.data;
      });
    },
    editar(id) {
      this.modo = "update";
      axios.get("http://localhost:8090/item/" + id, this.novoItem).then(res => {
        this.novoItem = res.data;
      });
    },
    remover(id) {
      this.modo = "list";
      axios({
        url: "http://localhost:8090/item/cpf/" + this.user.cpf + "/" + id,
        method: "DELETE",
        data: null
      }).then(res => {
        this.buscar();
      });
    },
    update() {
      axios
        .put(
          "http://localhost:8090/item/cpf/" +
            this.user.cpf +
            "/" +
            this.novoItem.id,
          this.novoItem
        )
        .then(res => {
          this.modo = "list";
          this.novoItem = {};
          this.buscar();
        });
    },
    add() {
      axios
        .post("http://localhost:8090/item/cpf/" + this.user.cpf, this.novoItem)
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
  width: 100%;
  float: left;
}
.right {
  width: 100%;
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

