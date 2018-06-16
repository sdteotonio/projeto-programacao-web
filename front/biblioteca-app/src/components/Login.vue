<template>
  <div>
    <div>
        <form @submit="doLogin()">
            <div ><i class="fa fa-book icon-custom"></i>
                <div class="d-flex align-items-center align-content-center align-self-center div-name-ufab">
                    <h2 class="d-inline-flex"><em>Biblioteca</em></h2>
                    <h1 class="d-inline-flex"><strong>&nbsp;UFAB</strong><br></h1>
                </div>
            </div>
            <div class="form-group"><input class="form-control"  type="text" v-model='credenciais.usuario' placeholder="Usuário"></div>
            <div class="form-group"><input class="form-control" type="password" v-model='credenciais.senha' placeholder="Senha"></div>
            <div class="form-group"><button type="submit">Entrar</button></div>
        </form>
    </div>
  </div>
</template>


<script >
import axios from "axios";
export default {
  name: "Login",
  data() {
    return {
      credenciais: {
        usuario: "iron",
        senha: "asd"
      },
      response: ""
    };
  },
  mounted() {
    if (sessionStorage.getItem("usr") != null) {
      this.$router.push("dash");
    }
  },
  methods: {
    doLogin() {
      axios
        .post("http://localhost:8090/usuario/login", this.credenciais)
        .then(res => {
          sessionStorage.setItem("usr", JSON.stringify(res.data));
          this.$router.push("dash");
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
