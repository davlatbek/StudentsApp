package innopolis.studentsapp.adapters;

import android.app.Fragment;
import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import innopolis.studentsapp.R;
import innopolis.studentsapp.entities.Student;
import innopolis.studentsapp.fragments.StudentListFragment;
import innopolis.studentsapp.interfaces.StudentItemClickListener;

/**
 * Created by davlet on 6/29/17.
 */

public class RVStudentAdapter extends RecyclerView.Adapter<RVStudentAdapter.ItemHolder>{
    List<Student> studentList;
    List<Student> studentListCopy;
    LayoutInflater layoutInflater;
    StudentItemClickListener studentItemClickListener;
    StudentListFragment fragment;

    public RVStudentAdapter(Context context, List<Student> studentList, Fragment fragment) {
        this.studentList = studentList;
        studentListCopy = new ArrayList<>();
        studentListCopy.addAll(studentList);
        layoutInflater = LayoutInflater.from(context);
        this.fragment = (StudentListFragment) fragment;
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
        fragment.registerForContextMenu(holder.cardViewStudent);
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

    class ItemHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        CardView cardViewStudent;
        ImageView studentPhoto;
        TextView textStudentName;
        TextView textStudentSurname;

        ItemHolder(View itemView) {
            super(itemView);
            studentPhoto = (ImageView) itemView.findViewById(R.id.rvStudentPhoto);
            textStudentName = (TextView) itemView.findViewById(R.id.rvTextStudentName);
            textStudentSurname = (TextView) itemView.findViewById(R.id.rvTextStudentSurname);
            cardViewStudent = (CardView) itemView.findViewById(R.id.cardViewStudent);
            cardViewStudent.setOnLongClickListener(onLongClickListener);
            cardViewStudent.setOnClickListener(onClickListener);
        }

        @Override
        public void onClick(View v) {
            if (studentItemClickListener != null)
                studentItemClickListener.onItemClick(v, getAdapterPosition());
        }

        private View.OnLongClickListener onLongClickListener = new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                fragment.phoneNumber = studentList.get(getAdapterPosition()).getContacts().get(0).getValue();
                return false;
            }
        };

        private View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (studentItemClickListener != null)
                    studentItemClickListener.onItemClick(v, getAdapterPosition());
            }
        };
    }

    public void setStudentItemClickListener(StudentItemClickListener studentItemClickListener){
        this.studentItemClickListener = studentItemClickListener;
    }

    public Student getStudentByPosition(int i){
        return studentList.get(i);
    }

    public Long getStudentIdAtPosition(int i){
        return studentList.get(i).getId();
    }
}
