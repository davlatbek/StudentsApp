package innopolis.studentsapp.adapters;

import android.content.Context;
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

/**
 * Created by davlet on 6/29/17.
 */

public class RVStudentAdapter extends RecyclerView.Adapter<RVStudentAdapter.ItemHolder>{
    List<Student> studentList;
    List<Student> studentListCopy;
    LayoutInflater layoutInflater;
    StudentItemClickListener studentItemClickListener;

    public RVStudentAdapter(Context context, List<Student> studentList) {
        this.studentList = studentList;
        studentListCopy = new ArrayList<>();
        studentListCopy.addAll(studentList);
        layoutInflater = LayoutInflater.from(context);
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

    class ItemHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView studentPhoto;
        TextView textStudentName;
        TextView textStudentSurname;

        ItemHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            studentPhoto = (ImageView) itemView.findViewById(R.id.rvStudentPhoto);
            textStudentName = (TextView) itemView.findViewById(R.id.rvTextStudentName);
            textStudentSurname = (TextView) itemView.findViewById(R.id.rvTextStudentSurname);
        }

        @Override
        public void onClick(View v) {
            if (studentItemClickListener != null)
                studentItemClickListener.onItemClick(v, getAdapterPosition());
        }
    }

    public void setStudentItemClickListener(StudentItemClickListener studentItemClickListener){
        this.studentItemClickListener = studentItemClickListener;
    }

    public Long getStudentIdAtPosition(int i){
        return studentList.get(i).getId();
    }
}
