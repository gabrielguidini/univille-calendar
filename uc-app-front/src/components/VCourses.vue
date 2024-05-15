<template>
  <div class="table-cursos">
    <v-table fixed-header="true" :height="tableHeight">
      <thead class="thead-table">
        <tr>
          <th class="text-left">ID</th>
          <th class="text-left">Name</th>
          <th class="button-container text-left"></th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="item in cursos" :key="item.name">
          <td>{{ item.id }}</td>
          <td>{{ item.name }}</td>
          <td class="button-container text-left">
            <v-btn color="light-blue-darken-1">Visualizar</v-btn>
          </td>
        </tr>
      </tbody>
    </v-table>
  </div>
</template>

<script>
export default {
  components: {},
  data() {
    return {
      cursos: [
        {
          name: 'Administração',
          id: 1
        },
        {
          name: 'Arquitetura e Urbanismo',
          id: 2
        },
        {
          name: 'Artes Visuais',
          id: 3
        },
        {
          name: 'Ciências Biológicas - Bacharelado',
          id: 4
        },
        {
          name: 'Ciências Contábeis',
          id: 5
        },
        {
          name: 'Ciências Econômicas',
          id: 6
        },
        {
          name: 'Cinema e Audiovisual',
          id: 7
        },
        {
          name: 'Comércio Exterior',
          id: 8
        },
        {
          name: 'Design',
          id: 9
        },
        {
          name: 'Direito',
          id: 10
        },
        {
          name: 'Educação Física - Bacharelado',
          id: 11
        },
        {
          name: 'Educação Física - Licenciatura',
          id: 12
        },
        {
          name: 'Engenharia Ambiental e Sanitária',
          id: 13
        },
        {
          name: 'Engenharia de Produção',
          id: 14
        },
        {
          name: 'Engenharia de Software',
          id: 15
        },
        {
          name: 'Engenharia Química',
          id: 16
        },
        {
          name: 'Farmácia',
          id: 17
        },
        {
          name: 'Fisioterapia',
          id: 18
        },
        {
          name: 'Gastronomia',
          id: 19
        },
        {
          name: 'História',
          id: 20
        },
        {
          name: 'Letras - Português e Inglês - Bacharelado',
          id: 21
        },
        {
          name: 'Letras – Português e Inglês - Licenciatura',
          id: 22
        },
        {
          name: 'Medicina',
          id: 23
        },
        {
          name: 'Nutrição',
          id: 24
        },
        {
          name: 'Publicidade e Propaganda',
          id: 25
        },
        {
          name: 'Sistemas de Informação',
          id: 26
        }
      ]
    }
  },
  props: {
    tableHeight: {
      type: Number,
      default: 500
    }
  }
}
</script>

<style scoped>
.container {
  width: 100vw;
  height: 100vh;
  padding: 20px;
  background-color: #e0e0e0;
}

.header {
  padding: 5px 20px;
  color: #212121;
  background-color: #fafafa;
  border-radius: 5px;
}

.items-table {
  display: flex;
  flex-direction: column;
  gap: 5px;
  height: 100%;
  margin-left: 255px;
  /* border: solid 1px red; */
}

.button-container {
  display: flex;
  justify-content: flex-end;
  flex-direction: row;
  align-items: center;
}

.table-cursos {
  overflow: hidden;
  box-sizing: border-box;
  /* border: solid 1px green; */
}
</style>
