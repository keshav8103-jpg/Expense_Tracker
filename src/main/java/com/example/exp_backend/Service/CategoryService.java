    package com.example.exp_backend.Service;

    import java.util.List;

    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Service;

    import com.example.exp_backend.Model.CategoryModel;
    import com.example.exp_backend.Repo.CategoryRepo;

    @Service 
    public class CategoryService 
    {
        @Autowired 
        private CategoryRepo categoryRepo;


        //addd category--------------------------------------
        public CategoryModel addCategory(CategoryModel category)
        {
            return categoryRepo.save(category);
        }    

        //get category------------------------------------------
        public List<CategoryModel> getAllCategory()
        {
            return categoryRepo.findAll();
        }

        //get category by id-------------------------------------
        public CategoryModel getCategoryById(Long id)
        {
            return categoryRepo.findById(id).orElse(null);
        }

        //update category-------------------------------------------

        public CategoryModel updateCategory(Long id, CategoryModel updateCategory)
        {
            CategoryModel category=categoryRepo.findById(id).orElse(null);

            if(category!=null)
            {
                category.setName(updateCategory.getName());
                category.setDescription(updateCategory.getDescription());

                return categoryRepo.save(category);
            }

            return null;
        }

        //delete category----------------------------------------------
        public String deleteCategory(Long id)
        {
            CategoryModel category=categoryRepo.findById(id).orElse(null);

            if(category!=null)
            {
                categoryRepo.deleteById(id);

                return "Category deleted Successfully";
            }

            return "Category not found";
        }
    }
