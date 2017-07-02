package innopolis.studentsapp.adapters;

import android.app.Fragment;
import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import innopolis.studentsapp.R;
import innopolis.studentsapp.entities.Student;
import innopolis.studentsapp.interfaces.OnItemLongClickListener;
import innopolis.studentsapp.interfaces.StudentItemClickListener;

/**
 * Created by davlet on 6/29/17.
 */

public class RVStudentAdapter extends RecyclerView.Adapter<RVStudentAdapter.ItemHolder>{
    List<Student> studentList;
    List<Student> studentListCopy;
    LayoutInflater layoutInflater;
    StudentItemClickListener studentItemClickListener;
    Fragment fragment;
    OnItemLongClickListener onItemLongClickListener;

    public RVStudentAdapter(Context context, List<Student> studentList, Fragment fragment) {
        this.studentList = studentList;
        studentListCopy = new ArrayList<>();
        studentListCopy.addAll(studentList);
        layoutInflater = LayoutInflater.from(context);
        this.fragment = fragment;
    }

    @Override
    public ItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.rv_student_item, parent, false);
        return new ItemHolder(view);
    }

    @Override
    public void onBindViewHolder(ItemHolder holder, int position) {
        holder.studentPhoto.setImageResource(studentList.get(position).getPhotoId());
        holder.textStudentName.setText(studentList.get(position).getName());
        holder.textStudentSurname.setText(studentList.get(position).getSurname());
        holder.itemView.setLongClickable(true);
        fragment.registerForContextMenu(holder.studentPhoto);
    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }

    public void filter(CharSequence s) {
        s = s.toString().toLowerCase();
        studentList.clear();
        for (Student student: studentListCopy){
            if (student.getName().toLowerCase().contains(s))
                studentList.add(student);
        }
        notifyDataSetChanged();
    }

    class ItemHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
        CardView cardViewStudent;
        ImageView studentPhoto;
        TextView textStudentName;
        TextView textStudentSurname;

        ItemHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
            studentPhoto = (ImageView) itemView.findViewById(R.id.rvStudentPhoto);
            textStudentName = (TextView) itemView.findViewById(R.id.rvTextStudentName);
            textStudentSurname = (TextView) itemView.findViewById(R.id.rvTextStudentSurname);
            cardViewStudent = (CardView) itemView.findViewById(R.id.cardViewStudent);
        }

        @Override
        public void onClick(View v) {
            if (studentItemClickListener != null)
                studentItemClickListener.onItemClick(v, getAdapterPosition());
        }

        @Override
        public boolean onLongClick(View v) {
            if (onItemLongClickListener != null)
                onItemLongClickListener.onItemLongClicked(v, getAdapterPosition());
            return true;
        }
    }

    public void setStudentItemClickListener(StudentItemClickListener studentItemClickListener){
        this.studentItemClickListener = studentItemClickListener;
    }

    public void setOnItemLongClickListener(OnItemLongClickListener onItemLongClickListener){
        this.onItemLongClickListener = onItemLongClickListener;
    }

    public Student getStudentByPosition(int i){
        return studentList.get(i);
    }

    public Long getStudentIdAtPosition(int i){
        return studentList.get(i).getId();
    }
}
