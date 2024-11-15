import { render, screen,fireEvent,waitFor } from '@testing-library/react';
import '@testing-library/jest-dom';
import {Signup} from './Signup';

test('renders username, password, confirm password fields and signup button', () => {
    render(<Signup />);
    
    const username = screen.getByLabelText(/username/i);
    const password = screen.getByLabelText(/enter password/i);
    const confirmPassword = screen.getByLabelText(/confirm password/i);
    const button = screen.getByRole('button', { name: /sign up/i });

    expect(username).toBeInTheDocument();
    expect(password).toBeInTheDocument();
    expect(confirmPassword).toBeInTheDocument();
    expect(button).toBeInTheDocument();
});



test('shows error message if username is greater than 7 characters', () => {
    render(<Signup />);
    
    const usernameInput = screen.getByLabelText(/username/i);
    fireEvent.change(usernameInput, { target: { value: 'longusername' } });
    
    const errorText = screen.getByText(/username should be less than 7 characters/i);
    expect(errorText).toBeInTheDocument();
});



test('shows error message if passwords do not match',  () => {
    render(<Signup />);
    
    const passwordInput = screen.getByLabelText(/enter password/i);
    const confirmPasswordInput = screen.getByLabelText(/confirm password/i);
    
    fireEvent.change(passwordInput, { target: { value: 'password123' } });
    fireEvent.change(confirmPasswordInput, { target: { value: 'password321' } });
    
        const errorText = screen.getByText(/passwords do not match/i);
        expect(errorText).toBeInTheDocument();
});


test('disables sign up button if there are validation errors', () => {
    render(<Signup />);
    
    const usernameInput = screen.getByLabelText(/username/i);
    fireEvent.change(usernameInput, { target: { value: 'longusername' } });
    
    const button = screen.getByRole('button', { name: /sign up/i });
    expect(button).toBeDisabled();
});


test('enables sign up button if all fields are valid', () => {
    render(<Signup />);
    
    const usernameInput = screen.getByLabelText(/username/i);
    const passwordInput = screen.getByLabelText(/enter password/i);
    const confirmPasswordInput = screen.getByLabelText(/confirm password/i);
    
    fireEvent.change(usernameInput, { target: { value: 'user' } });
    fireEvent.change(passwordInput, { target: { value: 'password123' } });
    fireEvent.change(confirmPasswordInput, { target: { value: 'password123' } });
    
    const button = screen.getByRole('button', { name: /sign up/i });
    expect(button).toBeEnabled();
});



test('renders header after timeout', async () => {
    render(<Signup />);
    
    const header = await screen.findByRole('heading', { name: /welcome to signup/i });

    expect(header).toBeInTheDocument();

});



