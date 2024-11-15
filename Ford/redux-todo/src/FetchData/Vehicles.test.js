import { screen,fireEvent,waitFor,render } from "@testing-library/react";
import '@testing-library/jest-dom'


import React from 'react';
import { Vehicles } from "./Vehicles";


global.fetch = jest.fn(() =>
    Promise.resolve({
      json: () =>
        Promise.resolve([
          { id: 1, isAvailable: true, brandName: "Tata" },
          { id: 2, isAvailable: false, brandName: "Honda" }
        ])
    })
  );
  


describe('Vehicles Component',()=>{

       beforeEach(()=>{
           fetch.mockClear();
       })

       test('render the component and check the initial state',()=>{

             render(<Vehicles/>);

             
             expect(screen.getByText("...Click to getData")).toBeInTheDocument();

             const all = screen.getByLabelText("Get All Vehicle")

             expect(all).toBeInTheDocument();
             expect(all).not.toBeChecked();

             const available = screen.getByLabelText("Get Available Vehicle");
             
             expect(available).toBeInTheDocument();
             expect(available).not.toBeChecked();

             const unavailable = screen.getByLabelText("Get Unavailable Vehicle");

             expect(unavailable).toBeInTheDocument();
             expect(unavailable).not.toBeChecked();
             

       })

       
       test('fetches all available vehicles when Get all Vehicles checkbox is clicked',async ()=>{

        render(<Vehicles/>)
        const all = screen.getByLabelText("Get All Vehicle");
        fireEvent.click(all);
        const url = 'http://localhost:8080/vehicles/getAll'
        await waitFor(()=> expect(fetch).toHaveBeenCalledWith(url));

        
        // wait for data
        await waitFor(()=>expect(screen.getByText('isAvailable:true').toBeInTheDocument()));
         
        // Check the correct number of vehicle data is rendered
        //  expect(screen.getAllByText(/isAvailable:/).length).toBe(2);
             
       })
       


})










