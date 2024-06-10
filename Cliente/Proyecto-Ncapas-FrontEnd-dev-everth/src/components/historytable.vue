<template>
<v-data-table :headers="headers_type" :items="entries" item-key="id" items-per-page="10" class="mt-5"
style="background-color: #EDF1F4; font-family: 'Josefin Sans', sans-serif;"
>

<template v-slot:header.nombre="{ column }">
 <span class="title">{{ column.title }}</span> 
</template>
<template v-slot:header.tipo="{ column }">
 <span class="title">{{ column.title }}</span> 
</template>
<template v-slot:header.fecha="{ column }">
 <span class="title">{{ column.title }}</span> 
</template>
<template v-slot:header.acceso="{ column }">
 <span class="title">{{ column.title }}</span> 
</template>
<template v-slot:header.hora="{ column }">
 <span class="title">{{ column.title }}</span> 
</template>
</v-data-table>
</template>
  
  <script>
  export default {
    name: 'HistoryTable',
    props: {
        entries: {
            type: Array,
            required: true
        },
    },
    data: () => ({
        headers_type: [],
        headers: [
        { title: 'Nombre', value: 'nombre'},
        { title: 'Tipo', value: 'tipo' },
        { title: 'Fecha', value: 'fecha' },
        { title: 'Acceso', value: 'acceso' },
        { title: 'Hora', value: 'hora'},
      ],
      headers_resident: [
        { title: 'Nombre', value: 'nombre'},
        { title: 'Fecha', value: 'fecha' },
        { title: 'Acceso', value: 'acceso' },
        { title: 'Hora', value: 'hora'},
      ],
    }),
    mounted(){
      console.log(this.entries[0].tipo !== undefined);
      if(this.entries[0].tipo !== undefined){
        this.headers_type = this.headers;
      }else{
        this.headers_type = this.headers_resident;
      }
  }
}
  </script>
  
  <style scoped>
  .title{
    font-size: 24px;
  }
  @media (max-width: 768px) {
  .title{
    font-size: 14px;
  }
}
  </style>
  