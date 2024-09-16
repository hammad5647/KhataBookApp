package com.example.khatabook.adapters

import android.Manifest
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.ActivityResultLauncher
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.khatabook.R
import com.example.khatabook.databinding.UserSampleBinding
import com.example.khatabook.models.EntityModel

class UserAdapter(
    private var list: MutableList<EntityModel>,
    private var permission: ActivityResultLauncher<Array<String>>
) :
    RecyclerView.Adapter<UserAdapter.UserViewHolder>() {
    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var binding = UserSampleBinding.bind(itemView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.user_sample, parent, false)
        return UserViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.binding.userNameTxt.text = list[position].cuName
        holder.binding.userMobileTxt.text = list[position].cuMobile

        holder.binding.mssgeBtn.setOnClickListener {
            if (holder.binding.mssgeBtn.context.checkSelfPermission(Manifest.permission.SEND_SMS) ==
                android.content.pm.PackageManager.PERMISSION_GRANTED
            ) {
                var mssgeSent = Intent(Intent.ACTION_SEND)
                mssgeSent.data = Uri.parse("Message to :${list[position].cuMobile}")
                startActivity(holder.binding.mssgeBtn.context,mssgeSent,null)
            }
        }
    }
}