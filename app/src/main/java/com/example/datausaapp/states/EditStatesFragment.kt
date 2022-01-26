package com.example.datausaapp.states

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.datausaapp.R
import com.example.datausaapp.data.model.State
import kotlinx.android.synthetic.main.fragment_edit_city.view.*

import java.lang.Exception

class EditStatesFragment(private val state: State, private val onSavedState: (State) -> Unit) :
    Fragment() {

    private lateinit var editName: TextView
    private lateinit var editID: EditText
    private lateinit var editState: EditText
    private lateinit var editYear: EditText
    private lateinit var editPopulation: EditText
    private lateinit var editSlug: EditText

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_edit_city, container, false)

        loadingStateData(view)
        setListeners(view)
        return view
    }

    private fun loadingStateData(view: View) {

        editName = view.textview_nome_state
        editID = view.edit_ID
        editState = view.edit_State
        editYear = view.edit_Year
        editPopulation = view.edit_Population
        editSlug = view.edit_slug

        editName.text = "Editar dados do ${state.state}"
        editID.isEnabled = false
        editID.setText(state.stateId)
        editState.setText(state.state)
        editYear.setText(state.year.toString())
        editPopulation.setText(state.population.toString())
        editSlug.setText(state.slugState)

    }

    private fun setListeners(view: View) {

        view.savedbutton.setOnClickListener {

            if (fieldValidate()) {
                try {
                    onSavedState(createNewState())
                    //retornando para o fragment anterior
                    activity?.supportFragmentManager?.popBackStack()

                } catch (e: Exception) {
                    Toast.makeText(
                        requireContext(),
                        "População e ano devem ser inteiros",
                        Toast.LENGTH_SHORT
                    ).show()

                }

            } else {
                Toast.makeText(
                    requireContext(),
                    "Todos os campos devem ser preenchidos",
                    Toast.LENGTH_SHORT
                ).show()
            }

        }
    }

    private fun createNewState(): State {

        return state.copy(
            state = editState.text.toString(),
            population = editPopulation.text.toString().toInt(),
            slugState = editSlug.text.toString(),
            year = editYear.text.toString().toInt()

        )
    }

    private fun fieldValidate(): Boolean {
        return !(editState.text.isNullOrBlank() || editPopulation.text.isNullOrBlank() ||
                editSlug.text.isNullOrBlank() || editYear.text.isNullOrBlank())
    }
}