<template>
  <toast />
</template>

<script>
import { toast } from "vue3-toastify";
import "vue3-toastify/dist/index.css";

export default {
  name: "VToast",
  data() {
    return {
      toast,
    };
  },
};
</script>
