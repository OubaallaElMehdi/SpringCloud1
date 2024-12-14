import axios from "axios";

const API_URL = "http://localhost:8888/ms-client";

export const getAllClients = () => {
  return axios.get(`${API_URL}/clients`);
};
