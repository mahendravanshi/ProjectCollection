import React, { useState, useEffect } from 'react';

export const Signup = () => {
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
    const [confirmPassword, setConfirmPassword] = useState('');
    const [errors, setErrors] = useState({ username: '', password: '', confirmPassword: '', usernameError: false, passwordError: false });
    const [isSubmitDisabled, setSubmitDisabled] = useState(true);
    const [message, setMessage] = useState('');

    useEffect(() => {
        setTimeout(() => {
            setMessage('welcome to signup');
        }, 1000);
    }, []);

    const validateUsername = (value, e1) => {
        if (value.length >= 7 || value.length===0) {
            e1.usernameError = true;
            e1.username = 'Username should be less than 7 characters';
        } else {
            e1.usernameError = false;
            e1.username = '';
        }
    };

    const validatePasswords = (password, confirmPassword, e1) => {
        if (password !== confirmPassword) {
            e1.passwordError = true;
            e1.password = 'Passwords do not match';
        } else {
            e1.passwordError = false;
            e1.password = '';
        }
    };

    const handleUsernameChange = (e) => {
        const value = e.target.value;
        setUsername(value);
        const e1 = { ...errors };
        validateUsername(value, e1);
        setErrors(e1);
        checkFormValidity(e1);
    };
    

    const handlePasswordChange = (e) => {
        const value = e.target.value;
        setPassword(value);
    };

    const handleConfirmPasswordChange = (e) => {
        const value = e.target.value;
        setConfirmPassword(value);
        const e1 = { ...errors };
        validatePasswords(password, value, e1);
        setErrors(e1);
        checkFormValidity(e1);
    };

    const checkFormValidity = (e1) => {
        const isValid = !e1.usernameError && !e1.passwordError;
        setSubmitDisabled(!isValid);
    };

      
    const handleSubmit = (e) => {
        e.preventDefault();
        // Mock async call
        setTimeout(() => {
            fetch('/signup', { method: 'POST' })
                .then(response => response.json())
                .then(data => setMessage(data.message));
        }, 500);
    };

    return (
        <form onSubmit={handleSubmit}>
            {message && <h1>{message}</h1>}
            <div>
                <label htmlFor="username">Username</label>
                <input
                    type="text"
                    id="username"
                    value={username}
                    onChange={handleUsernameChange}
                />
                {errors.usernameError && <p style={{ color: 'red' }}>{errors.username}</p>}
            </div>

            <div>
                <label htmlFor="password">Enter Password</label>
                <input
                    type="password"
                    id="password"
                    value={password}
                    onChange={handlePasswordChange}
                />
            
            </div>

            <div>
                <label htmlFor="confirmPassword">Confirm Password</label>
                <input
                    type="password"
                    id="confirmPassword"
                    value={confirmPassword}
                    onChange={handleConfirmPasswordChange}
                />
                {errors.passwordError && <p style={{ color: 'red' }}>{errors.password}</p>}
            </div>

            <button type="submit" disabled={isSubmitDisabled}>
                Sign up
            </button>
        </form>
    );
};
