import React, { useState } from 'react';
import { findVoitureById } from '../api/axiosConfig';

const VoitureDetails = () => {
    const [voitureId, setVoitureId] = useState('');
    const [voiture, setVoiture] = useState(null);

    const handleSearch = () => {
        findVoitureById(voitureId)
            .then(response => setVoiture(response.data))
            .catch(error => console.error('Error fetching voiture:', error));
    };

    return (
        <div className="container mt-4">
            <h2>Voiture Details</h2>
            <div className="mb-3">
                <label className="form-label">Enter Voiture ID</label>
                <input
                    type="number"
                    className="form-control"
                    value={voitureId}
                    onChange={(e) => setVoitureId(e.target.value)}
                />
                <button onClick={handleSearch} className="btn btn-primary mt-2">
                    Search
                </button>
            </div>
            {voiture && (
                <div className="card">
                    <div className="card-body">
                        <h5 className="card-title">{voiture.marque}</h5>
                        <p className="card-text">Matricule: {voiture.matricule}</p>
                        <p className="card-text">Model: {voiture.model}</p>
                    </div>
                </div>
            )}
        </div>
    );
};

export default VoitureDetails;
