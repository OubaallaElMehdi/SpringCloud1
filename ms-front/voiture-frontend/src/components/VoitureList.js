import React, { useEffect, useState } from "react";
import { getAllVoitures } from "../services/VoitureService";
import AddVoiture from "./AddVoiture";

const VoitureList = () => {
  const [voitures, setVoitures] = useState([]);

  const fetchVoitures = async () => {
    try {
      const response = await getAllVoitures();
      setVoitures(response.data);
    } catch (error) {
      console.error("Error fetching voitures:", error);
    }
  };

  useEffect(() => {
    fetchVoitures();
  }, []);

  return (
    <div>
      <h2>Voitures List</h2>
      <table className="table table-striped">
        <thead>
          <tr>
            <th>ID</th>
            <th>Marque</th>
            <th>Matricule</th>
            <th>Model</th>
            <th>Client ID</th>
          </tr>
        </thead>
        <tbody>
          {voitures.map((voiture) => (
            <tr key={voiture.id}>
              <td>{voiture.id}</td>
              <td>{voiture.marque}</td>
              <td>{voiture.matricule}</td>
              <td>{voiture.model}</td>
              <td>{voiture.id_client}</td>
            </tr>
          ))}
        </tbody>
      </table>
      <AddVoiture onAdd={fetchVoitures} />
    </div>
  );
};

export default VoitureList;
