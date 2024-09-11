import React, { useState } from 'react';
import '/home/renas/workspace/recipe-finder/src/css/InputIngredients.css'; // Import the CSS file

function InputIngredients() {
    const [ingredients, setIngredients] = useState([{ name: '', quantity: '', unit: '' }]);

    const units = ['kg', 'g', 'lbs', 'oz'];

    const handleNameChange = (index, value) => {
        const newIngredients = [...ingredients];
        if (value.length <= 25) {
            newIngredients[index].name = value;
            setIngredients(newIngredients);
        }
    };

    const handleQuantityChange = (index, value) => {
        const newIngredients = [...ingredients];
        if (value === '' || !isNaN(value)) {
            newIngredients[index].quantity = value;
            setIngredients(newIngredients);
        }
    };

    const handleUnitChange = (index, value) => {
        const newIngredients = [...ingredients];
        newIngredients[index].unit = value;
        setIngredients(newIngredients);
    };

    const addIngredient = () => {
        setIngredients([...ingredients, { name: '', quantity: '', unit: '' }]);
    };

    const handleSubmit = (e) => {
        e.preventDefault();
        ingredients.forEach((ingredient, index) => {
            console.log(`Ingredient ${index + 1} Name: ${ingredient.name}`);
            console.log(`Ingredient ${index + 1} Quantity: ${ingredient.quantity}`);
            console.log(`Ingredient ${index + 1} Unit: ${ingredient.unit}`);
        });
    };

    return (
        <form className="input-ingredients-form" onSubmit={handleSubmit}>
            <div className="ingredients-list">
                {ingredients.map((ingredient, index) => (
                    <div key={index} className="ingredient-row">
                        <div className="input-field">
                            <label htmlFor={`ingredientName-${index}`}>Name: </label>
                            <input 
                                type="text" 
                                id={`ingredientName-${index}`}
                                value={ingredient.name}
                                onChange={(e) => handleNameChange(index, e.target.value)}
                                placeholder="Name" 
                            />
                        </div>
                        <div className="input-field">
                            <label htmlFor={`quantity-${index}`}>Quantity: </label>
                            <input 
                                type="text" 
                                id={`quantity-${index}`}
                                value={ingredient.quantity}
                                onChange={(e) => handleQuantityChange(index, e.target.value)}
                                placeholder="Quantity" 
                            />
                        </div>
                        <div className="input-field">
                            <label htmlFor={`unit-${index}`}>Unit: </label>
                            <select 
                                id={`unit-${index}`} 
                                value={ingredient.unit} 
                                onChange={(e) => handleUnitChange(index, e.target.value)}>
                                <option value="">Select unit</option>
                                {units.map((unitItem, i) => (
                                    <option key={i} value={unitItem}>
                                        {unitItem}
                                    </option>
                                ))}
                            </select>
                        </div>
                    </div>
                ))}
                <div className="add-row-placeholder" onClick={addIngredient}>
                    <span className="plus-sign">+</span>
                </div>
            </div>
            <div className="button-container">
                <button type="submit" className="submit-button">submit</button>
            </div>
        </form>
    );
}

export default InputIngredients;
