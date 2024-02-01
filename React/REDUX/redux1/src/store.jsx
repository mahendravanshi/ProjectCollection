import { useStore } from "react-redux"
import { reducer as countReducer } from "./CounterRedux/reducer";
import { applyMiddleware, combineReducers, createStore, legacy_createStore } from "redux";
import {reducer as dataReducer} from "./ProductRedux/reducer"
import { thunk } from "redux-thunk";



const rootReducer = combineReducers({
    countReducer
    // dataReducer:dataReducer
})


export  const store = legacy_createStore(rootReducer,applyMiddleware(thunk))
