package com.asity.tech.suraksha

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.asity.tech.suraksha.databinding.FragmentPermissionBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.google.firebase.auth.FirebaseAuth


class PermissionFragment : Fragment() {
    private var _binding: FragmentPermissionBinding? = null
    private val binding get() = _binding!!
    private lateinit var mAuth: FirebaseAuth
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentPermissionBinding.inflate(inflater, container, false)
        val view = binding.root
        mAuth = FirebaseAuth.getInstance()
        val currentUser = mAuth.currentUser
        binding.userImg.let {
            Glide.with(this).load(currentUser?.photoUrl).apply(RequestOptions().override(300, 300))
                .into(
                    it
                )
        }

        binding.continueBtn.setOnClickListener {
            findNavController().navigate(R.id.action_permissionFragment_to_homeFragment)
        }

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}