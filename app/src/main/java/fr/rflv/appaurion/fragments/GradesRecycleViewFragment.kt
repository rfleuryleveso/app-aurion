package fr.rflv.appaurion.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import fr.rflv.appaurion.R
import fr.rflv.appaurion.adapters.GradesAdapter
import fr.rflv.appaurion.services.aurion.data.Course
import fr.rflv.appaurion.services.aurion.data.Mark
import fr.rflv.appaurion.viewmodels.GradesViewModel
import fr.rflv.appaurion.viewmodels.ScheduleViewModel
import kotlinx.coroutines.launch
import kotlinx.datetime.Clock
import kotlinx.datetime.toJavaInstant
import kotlinx.datetime.toKotlinLocalDate
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.time.ZoneId

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [GradesRecycleViewFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class GradesRecycleViewFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var adapter: GradesAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var grades: Array<Mark>

    private val scheduleViewModel by viewModel<GradesViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_grades_recycle_view, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment GradesRecycleViewFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            GradesRecycleViewFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeData()
        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.recycler_view_grades)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adapter = GradesAdapter(grades)
        recyclerView.adapter = adapter
    }

    private fun initializeData()
    {
        this.scheduleViewModel.loadMarks()

        lifecycleScope.launch() {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                scheduleViewModel.uiState.collect {
                    grades = it.grades
                }
            }
        }
    }
}